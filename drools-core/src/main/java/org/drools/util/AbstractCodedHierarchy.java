package org.drools.util;

import java.util.BitSet;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mamad
 * Date: 11/2/13
 * Time: 1:58 AM
 * To change this template use File | Settings | File Templates.
 */
public interface AbstractCodedHierarchy<T> {
    public int size();


    public void addMember( T val, BitSet key );

    public void removeMember( T val );

    public void removeMember( BitSet key );



    public BitSet getCode( T val );

    public BitSet metMembersCode( Collection<T> vals );

    public BitSet jointMembersCode( Collection<T> vals );

    public BitSet meetCode( Collection<BitSet> codes );

    public BitSet joinCode( Collection<BitSet> codes );



    public List<T> getSortedMembers();

    public Map<T,BitSet> getSortedMap();

    public T getMember( BitSet key );

    public boolean hasKey( BitSet key );

    /**
     * Return the "ceiling" of the key's descendants, up to and including the element whose code is key
     * @param key a key, possibly the join of a number of member keys
     * @return
     */
    public Collection<T> lowerBorder( BitSet key );

    /**
     * * Return the "ceiling" of the key's descendants, excluding the element whose code is key, if any
     * @param key a key, possibly the join of a number of member keys
     * @return
     */
    public Collection<T>    immediateChildren( BitSet key );

    /**
     * Returns all elements whose code is a descendant of key
     * @param key
     * @return
     */
    public Collection<T> lowerDescendants( BitSet key );




    // These methods assume that a node is known, by value or key, and will navigate the precomputed structure

    public Collection<T> parents( T x );

    public Collection<T> parents( BitSet x );


    // These methods work with a generic key, which need not correspond to a particular element

    /**
     * Return the "floor" of the key's ancestors, down to and including the element whose code is key, if any
     * @param key a key, possibly the meet of a number of member keys
     * @return
     */
    public Collection<T> upperBorder( BitSet key );

    /**
     *
     * Return the "floor" of the key's ancetsors, down to and excluding the element whose code is key
     * @param key a key, possibly the meet of a number of member keys
     * @return
     */
    public Collection<T> immediateParents( BitSet key );

    /**
     * Returns all elements whose code is an ancestor of key
     * @param key
     * @return
     */
    public Collection<T> upperAncestors( BitSet key );
}
